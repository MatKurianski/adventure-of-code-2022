(ns adventure-of-code-2022.day-4
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(defn ^:private subset?
  [s1 s2]
  (or (set/subset? s1 s2)
      (set/subset? s2 s1)))

(defn ^:private parse-range
  [unformatted-range]
  (->> unformatted-range
       (#(str/split % #"-"))
       (#(range (Integer/parseInt (first %)) (inc (Integer/parseInt (second %)))))))

(defn camp-cleanup-part-1
  [input]
  (->> input
       (str/split-lines)
       (map #(str/split % #","))
       (map (partial map parse-range))
       (map (partial map set))
       (map (partial apply subset?))
       (filter true?)
       (count)))

(defn camp-cleanup-part-2
  [input]
  (->> input
       (str/split-lines)
       (map #(str/split % #","))
       (map (partial map parse-range))
       (map (partial map set))
       (map (partial apply set/intersection))
       (map count)
       (remove zero?)
       (count)))
