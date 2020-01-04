(ns game.chess.friend-or-foe
  (:require
    [game.chess.pieces-on-board :refer [get-piece]]
    ))

(defn add-to [l s r]
  (assoc r l (conj (l r) s))
)

(defn- friend-or-foe [s c b]
  (if (= c (:color (get-piece s b))) "friend" "foe"))

(defn add-friend-or-foe [s c m b]
  (if (= "friend" (friend-or-foe s c b))
    (add-to :friends s m)
    (add-to :foes s m)))
