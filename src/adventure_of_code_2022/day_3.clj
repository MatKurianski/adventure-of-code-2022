(ns adventure-of-code-2022.day-3
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(defn ^:private letter-points
  [letter]
  (-> (if (Character/isUpperCase letter)
        (+ 26 (- (int letter) (int \A)))
        (- (int letter) (int \a)))
      inc))

(defn ^:private line-points
  [acc line]
  (->> line
       (partition-all (/ (count line) 2))
       (map set)
       (apply set/intersection)
       (first)
       (letter-points)
       (+ acc)))

(defn rucksack-organization-part-1
  [input]
  (->> input
       (str/split-lines)
       (reduce line-points 0)))

(defn rucksack-organization-part-2
  [input]
  (->> input
       (str/split-lines)
       (partition-all 3)
       (map (partial map set))
       (map (partial apply set/intersection))
       (map first)
       (map letter-points)
       (apply +)))
