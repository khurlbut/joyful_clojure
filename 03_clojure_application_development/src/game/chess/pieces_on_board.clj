(ns game.chess.pieces-on-board
  (:require
    [game.chess.piece :refer [new-piece]]
    ))

; (def pieces-on-board {})
;
(defn set-piece
  ([s c r b] (set-piece s (new-piece c r) b))
  ([s p b] (assoc b s p))
)

(defn remove-piece [s b] (dissoc b s))

(defn get-piece [s b] (get b s))

(defn square-occupied [s b] (contains? b s))

(defn square-empty [s b] (not (square-occupied s b)))
