(ns game.colors)

(def colors {:black "Black" :white "White"})

(defn color? [c] (contains? colors c))

(defn color [c] (if (color? c) c nil))
