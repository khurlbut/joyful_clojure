(ns game.chess.piece
  (:require [game.colors :refer :all]
            [game.chess.ranks :refer :all]))

(defn new-piece [c r]
  {
    :color (c colors)
    :rank (r ranks)
  }
)
;
; (defn piece? [p]
;   (if (= (p :colors))))
