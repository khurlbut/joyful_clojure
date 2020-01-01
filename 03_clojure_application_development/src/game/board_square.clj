(ns game.board-square
  (:require [game.colors :refer :all]
            [game.board-vectors :refer :all]
            [game.board-foundation :refer [get-row-num]]))

; Square color handling
; 'shift' the square number of odd rows (+ 1 to square num)
; then apply regular even/odd for black/white
(defn- row-number-is-even [s]
  (= (mod (get-row-num s) 2) 0))

(defn- shift-amount [s]
  (if (row-number-is-even s) 0 1))

(defn- row-shifted-square-number [s]
  (+ (shift-amount s) s))

(defn- shifted-square-num-is-even [s]
  (= (mod (row-shifted-square-number s) 2) 0))

(defn- shifted-color [s]
  (if (shifted-square-num-is-even s)
    (color :black)
    (color :white)))

(defn square [s]
  (let [sq {
          :id s
          :color (shifted-color s)
          :dirs {
            :north (get-vector-north s)
            :south (get-vector-south s)
            :east  (get-vector-east  s)
            :west  (get-vector-west  s)
            ;
            :north-east (get-vector-north-east s)
            :north-west (get-vector-north-west s)
            :south-east (get-vector-south-east s)
            :south-west (get-vector-south-west s)
            ;
            :north-1-square (get-vector-north s 1)
            :south-1-square (get-vector-south s 1)
            :east-1-square  (get-vector-east  s 1)
            :west-1-square  (get-vector-west  s 1)
            ;
            :north-east-1-square (get-vector-north-east s 1)
            :north-west-1-square (get-vector-north-west s 1)
            :south-east-1-square (get-vector-south-east s 1)
            :south-west-1-square (get-vector-south-west s 1)
            ;
            :north-2-squares (get-vector-north s 2)
            :south-2-squares (get-vector-south s 2)
            }}]
        sq))
