(ns game.board-vectors
  (:require [game.board-foundation :refer :all]))

(def reverse-vector true)

; f --> function (get-row-vector, get-col-vector etc..)
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

(defn get-vector-east
  ([s] (head-subvec get-row-vector s))
  ([s l] (tail-subvec (head-subvec get-row-vector s) l)))

(defn get-vector-west
  ([s] (head-subvec get-row-vector s reverse-vector))
  ([s l] (tail-subvec (head-subvec get-row-vector s reverse-vector) l)))

(defn get-vector-north
  ([s] (head-subvec get-col-vector s))
  ([s l] (tail-subvec (head-subvec get-col-vector s) l)))

(defn get-vector-south
  ([s] (head-subvec get-col-vector s reverse-vector))
  ([s l] (tail-subvec (head-subvec get-col-vector s reverse-vector) l)))

(defn get-vector-north-east
  ([s] (head-subvec get-south-west-vector s reverse-vector))
  ([s l] (tail-subvec (head-subvec get-south-west-vector s reverse-vector) l)))

(defn get-vector-north-west
  ([s] (head-subvec get-south-east-vector s reverse-vector))
  ([s l] (tail-subvec (head-subvec get-south-east-vector s reverse-vector) l)))

(defn get-vector-south-east
  ([s] (head-subvec get-south-east-vector s))
  ([s l] (tail-subvec (head-subvec get-south-east-vector s) l)))

(defn get-vector-south-west
  ([s] (head-subvec get-south-west-vector s))
  ([s l] (tail-subvec (head-subvec get-south-west-vector s) l)))
