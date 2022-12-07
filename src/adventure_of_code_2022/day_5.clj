(ns adventure-of-code-2022.day-5
  (:require [clojure.string :as str]))

(defn ^:private parse-int
  [number]
  (Integer/parseInt number))

(defn ^:private parse-moves
  [moves]
  (->> moves
       (map #(str/split % #" "))
       (map (partial drop 1))
       (map (partial take-nth 2))
       (map (partial map parse-int))))

(defn ^:private parse-crates
  [crates]
  (->> crates
       (map (partial partition-all 4))
       (map (partial map #(nth % 1)))
       (apply mapv vector)
       (map #(remove (partial = \space) %))
       (map drop-last)
       (zipmap (map inc (range)))
       (into (sorted-map))))

(defn supply-stacks-part-1
  [input]
  (let [input-partitioned (->> input
                               (str/split-lines) 
                               (partition-by empty?))
        [_crates _ _moves] input-partitioned
        crates (parse-crates _crates)
        moves (parse-moves _moves)]
    (->> (loop [crates crates
                [move-nth from to] (first moves)
                remaining-moves (rest moves)]
           (cond
             (nil? move-nth) crates
             :else (let [crates-to-move (->> (get crates from) (take move-nth))
                         updated-crates (-> crates
                                            (update from (partial drop move-nth))
                                            (update to into crates-to-move))]
                     (recur updated-crates (first remaining-moves) (rest remaining-moves))))) 
         (vals) 
         (map first)
         (str/join))))

(defn supply-stacks-part-2
  [input]
  (let [input-partitioned (->> input
                               (str/split-lines)
                               (partition-by empty?))
        [_crates _ _moves] input-partitioned
        crates (parse-crates _crates)
        moves (parse-moves _moves)]
    (->> (loop [crates crates
                [move-nth from to] (first moves)
                remaining-moves (rest moves)]
           (cond
             (nil? move-nth) crates
             :else (let [crates-to-move (->> (get crates from) (take move-nth) reverse)
                         updated-crates (-> crates
                                            (update from (partial drop move-nth))
                                            (update to into crates-to-move))]
                     (recur updated-crates (first remaining-moves) (rest remaining-moves)))))
         (vals)
         (map first)
         (str/join))))
