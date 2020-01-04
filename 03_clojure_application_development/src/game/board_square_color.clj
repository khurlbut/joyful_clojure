(ns game.board-square-color
  (:require
    [game.colors :refer [color]]
    [game.board-coordinates :refer [get-row-num]]
    ))

; Square Color Handling

; Strategy:
; 'Shift' the square number of odd rows (+ 1 to square num)
; then apply regular even/odd for black/white

(defn- row-number-is-even [s]
  (= (mod (get-row-num s) 2) 0))

(defn- shift-amount [s]
  (if (row-number-is-even s) 0 1))

(defn- row-shifted-square-number [s]
  (+ (shift-amount s) s))

(defn- shifted-square-num-is-even [s]
  (= (mod (row-shifted-square-number s) 2) 0))

(defn shifted-color [s]
  (if (shifted-square-num-is-even s)
    (color :black)
    (color :white)))
