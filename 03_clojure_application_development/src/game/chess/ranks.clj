(ns game.chess.ranks)

(def ranks {:rook "Rook" :knight "Knight" :bishop "Bishop" :queen "Queen" :king "King" :pawn "Pawn"})

(defn rank? [p] (contains? ranks p))

(defn rank [p] (if (rank? p) p nil))
