(ns game.board-dimensions)

(def dims {:rows 8 :cols 8})

(def max-board-squares (* (:rows dims) (:cols dims)))
