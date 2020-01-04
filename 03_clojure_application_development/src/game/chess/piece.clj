(ns game.chess.piece
  (:require
    [game.colors :refer [color]]
    [game.chess.ranks :refer [rank]]
    ))

(defn new-piece [c r]
  {
    :color (color c)
    :rank (rank r)
  }
)
