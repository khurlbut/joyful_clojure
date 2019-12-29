(ns game.board-square
  (:require [clojure.core :refer :all]
            [game.colors :refer :all]
            [game.board-vectors :refer :all]
            [game.board-foundation :refer :all]))

; Square color handling
(defn row-shifted-square-number [s]
  ; 'shift' the square number of odd rows (+ 1)
  (+ (if (= (mod (get-row-num s) 2) 0) 0 1) s))

(defn shifted-square-num-is-even [s]
  (= (mod (row-shifted-square-number s) 2) 0))

(defn color [s]
  (if (shifted-square-num-is-even s)
    (:black colors)
    (:white colors)))

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
