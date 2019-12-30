(ns game.board
  (:require [clojure.test :refer :all]
            [game.board-dimensions :refer :all]
            [game.board-square :refer :all]))

(defn- build-board []
  (for [i (range 0 max-board-squares)
    :let [sq (square i)]]
      sq))

(def game-board (vec (build-board)))

(defn get-square [sq]
  (get game-board sq))
