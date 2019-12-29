(ns game.board-square
  (:require [clojure.core :refer :all]
            [game.board-vectors :refer :all]
            [game.board-foundation :refer [get-row-num]]))

(defn row-adjusted-square-number [s]
  (+ (if (= (mod (get-row-num s) 2) 0) 0 1) s))

(defn color [s]
  (if (= (mod (row-adjusted-square-number s) 2) 0) "black" "white"))

(defn square [s]
  (let [sq {
          :id s
          :color (color s)
          :dirs {
            :north      (get-vector-north      s)
            :north-east (get-vector-north-east s)
            :east       (get-vector-east       s)
            :south-east (get-vector-south-east s)
            :south      (get-vector-south      s)
            :south-west (get-vector-south-west s)
            :west       (get-vector-west       s)
            :north-west (get-vector-north-west s)
            }}]
        sq))
