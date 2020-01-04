(ns game.board-coordinates
  (:require
    [game.board-dimensions :refer :all]
    ))

(def square-indexes (vec (range max-board-squares)))
(defn square-index? [s] (contains? square-indexes s))
(defn square-index [s] (if (square-index? s) s nil))

(defn get-row-num [s]
  (let [
    s (square-index s)
    c (float (dims :cols))
    r (/ s c)]
  (int r)))

(defn get-col-num [s]
  (let [
    s (square-index s)
    c (dims :cols)]
  (mod s c)))

(defn get-south-east-diag-num [s] (+ (get-col-num s) (get-row-num s)))
(defn get-south-west-diag-num [s] (- (get-col-num s) (get-row-num s)))
