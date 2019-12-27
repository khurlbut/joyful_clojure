(ns game.board-vectors
  (:require [game.board-foundation :refer :all]))

(def reverse-vector true)

; f --> function (get-row, get-col etc..)
; s --> square index
; r --> reverse (false by defaulto90p89)
(defn- head-subvec
  ([f s] (head-subvec f s false))
  ([f s r]
    (let [v (f s)
          v (if r (vec (rseq v)) v)
          i (.indexOf v s)
          sv (subvec v i)]
        (vec (rest sv)))))

(defn- tail-subvec
  [v l]
    (let [l (if (> l (count v)) (count v) l)]
    (subvec v 0 l)))

(defn- get-vector
  ([f s] (head-subvec f s))
  ([f s l] (tail-subvec (head-subvec f s) l)))

(defn- get-reverse-vector
  ([f s] (head-subvec f s reverse-vector))
  ([f s l] (tail-subvec (head-subvec f s reverse-vector) l)))

(defn get-vector-east
  [s & l] (apply get-vector get-row s l))

(defn get-vector-west
  [s & l] (apply get-reverse-vector get-row s l))

(defn get-vector-north
  [s & l] (apply get-vector get-col s l))

(defn get-vector-south
  [s & l] (apply get-reverse-vector get-col s l))

(defn get-vector-north-east
  [s & l] (apply get-reverse-vector get-south-west-diagonal s l))

(defn get-vector-north-west
  [s & l] (apply get-reverse-vector get-south-east-diagonal s l))

(defn get-vector-south-east
  [s & l] (apply get-vector get-south-east-diagonal s l))

(defn get-vector-south-west
  [s & l] (apply get-vector get-south-west-diagonal s l))
