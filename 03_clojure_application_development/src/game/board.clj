(ns game.board
  (:require [game.board-dimensions :refer :all]
            [game.board-square :refer :all]))

(defn- build-board []
  (for [i (range 0 max-board-squares)
    :let [s (square i)]]
  s))

(def game-board (vec (build-board)))

(defn get-board-square [s] (get game-board s))
