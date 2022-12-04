(ns adventure-of-code-2022.day-4-test
  (:require [clojure.test :refer :all]
            [adventure-of-code-2022.day-4 :as day-4]))

(deftest camp-cleanup-part-1-test
  (testing "Testing camp-cleanup-part-1"
    (let [input-1 (slurp "./resources/test/day_4/input1.txt")
          input-2 (slurp "./resources/test/day_4/input2.txt")]
      (is (= 2 (day-4/camp-cleanup-part-1 input-1)))
      (is (= 540 (day-4/camp-cleanup-part-1 input-2))))))

(deftest camp-cleanup-part-2-test
  (testing "Testing camp-cleanup-part-2"
    (let [input-1 (slurp "./resources/test/day_4/input1.txt")
          input-2 (slurp "./resources/test/day_4/input2.txt")]
      (is (= 4 (day-4/camp-cleanup-part-2 input-1)))
      (is (= 872 (day-4/camp-cleanup-part-2 input-2))))))
