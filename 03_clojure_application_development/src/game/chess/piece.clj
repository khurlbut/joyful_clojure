(ns game.chess.piece
  (:require [game.colors :refer :all]
            [game.chess.ranks :refer :all]))

(defn new-piece [c r]
  {
    :color (color c)
    :rank (rank r)
  }
)
;
; (defn piece? [p]
;   (if (= (p :colors))))
