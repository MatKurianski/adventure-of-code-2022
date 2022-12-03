(ns adventure-of-code-2022.day-3-test
  (:require [clojure.test :refer :all]
            [adventure-of-code-2022.day-3 :as day-3]))

(deftest rucksack-organization-part-1-test
  (testing "Testing rucksack-organization-part-1"
    (let [input-1 (slurp "./resources/test/day_3/input1.txt")
          input-2 (slurp "./resources/test/day_3/input2.txt")]
      (is (= 157 (day-3/rucksack-organization-part-1 input-1)))
      (is (= 7863 (day-3/rucksack-organization-part-1 input-2))))))

(deftest rucksack-organization-part-2-test
  (testing "Testing rucksack-organization-part-1"
    (let [input-1 (slurp "./resources/test/day_3/input1.txt")
          input-2 (slurp "./resources/test/day_3/input2.txt")]
      (is (= 70 (day-3/rucksack-organization-part-2 input-1)))
      (is (= 2488 (day-3/rucksack-organization-part-2 input-2))))))
