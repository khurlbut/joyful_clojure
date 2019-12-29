(ns game.board-square
  (:require [clojure.core :refer :all]
            [game.board-vectors :refer :all]))

(defn square [s]
  (let [sq {
          :id s
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
