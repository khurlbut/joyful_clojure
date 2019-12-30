(ns game.board
  (:require [clojure.test :refer :all]
            [game.board-square :refer :all]))

(defn board []
  (for [i (range 0 64)
    :let [sq (square i)]]
    [sq]))
