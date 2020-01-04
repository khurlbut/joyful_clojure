(ns game.chess.actions-foundation
  (:require
    [game.chess.pieces-on-board :refer [square-occupied]]
    [game.chess.friend-or-foe :refer [add-to add-friend-or-foe]]
    ))

(defn- merge-vector-in-maps
  [m1 m2 v]
  (assoc m1 v (vec (concat (v m1) (v m2)))))

(defn build-action-map [v c b]
  (let [colr c
        board b]
  (loop [remaining v action-map {}]
    (if (empty? remaining)
      action-map
      (let [s (first remaining)]
        (if (square-occupied s board)
          (add-friend-or-foe s colr action-map board)
          (let [next-remaining (rest remaining)
                next-results (add-to :moves s action-map)]
            (recur next-remaining next-results))))))))

(defn merge-maps
  ([m1 m2]
  (let [g1 (merge-vector-in-maps m1 m2 :moves)
        g2 (merge-vector-in-maps g1 m2 :friends)
        g3 (merge-vector-in-maps g2 m2 :foes)]
   g3)))
