458. Poor Pigs
     Solved
     Hard
     Topics
     Companies
     Hint
     There are buckets buckets of liquid, where exactly one of the buckets is poisonous. To figure out which one is poisonous, you feed some number of (poor) pigs the liquid to see whether they will die or not. Unfortunately, you only have minutesToTest minutes to determine which bucket is poisonous.

You can feed the pigs according to these steps:

Choose some live pigs to feed.
For each pig, choose which buckets to feed it. The pig will consume all the chosen buckets simultaneously and will take no time. Each pig can feed from any number of buckets, and each bucket can be fed from by any number of pigs.
Wait for minutesToDie minutes. You may not feed any other pigs during this time.
After minutesToDie minutes have passed, any pigs that have been fed the poisonous bucket will die, and all others will survive.
Repeat this process until you run out of time.
Given buckets, minutesToDie, and minutesToTest, return the minimum number of pigs needed to figure out which bucket is poisonous within the allotted time.

Example 1:

Input: buckets = 4, minutesToDie = 15, minutesToTest = 15
Output: 2
Explanation: We can determine the poisonous bucket as follows:
At time 0, feed the first pig buckets 1 and 2, and feed the second pig buckets 2 and 3.
At time 15, there are 4 possible outcomes:

- If only the first pig dies, then bucket 1 must be poisonous.
- If only the second pig dies, then bucket 3 must be poisonous.
- If both pigs die, then bucket 2 must be poisonous.
- If neither pig dies, then bucket 4 must be poisonous.
  Example 2:

Input: buckets = 4, minutesToDie = 15, minutesToTest = 30
Output: 2
Explanation: We can determine the poisonous bucket as follows:
At time 0, feed the first pig bucket 1, and feed the second pig bucket 2.
At time 15, there are 2 possible outcomes:

- If either pig dies, then the poisonous bucket is the one it was fed.
- If neither pig dies, then feed the first pig bucket 3, and feed the second pig bucket 4.
  At time 30, one of the two pigs must die, and the poisonous bucket is the one it was fed.

Constraints:

1 <= buckets <= 1000
1 <= minutesToDie <= minutesToTest <= 100

Key Insights
Time and Testing Rounds: We have minutesToTest and minutesToDie. This allows us to calculate the number of possible rounds of testing:

# rounds

minutesToTest
minutesToDie
rounds=
minutesToDie
minutesToTest
​

Each round provides feedback on which pigs die, which helps narrow down the potential poisonous bucket.

Binary Information from Each Pig:

Each pig can represent a "state" in each round. If it is given a specific set of buckets to drink from, it will either die or survive. With rounds available, a pig can represent
rounds

- 1
  rounds+1 outcomes (one for each round plus the possibility that it does not die).
  Therefore, each pig can test up to
  rounds
- 1
  rounds+1 different buckets.
  Combinatorial Approach:

The total number of outcomes for each pig across all rounds is
rounds

- 1
  rounds+1.
  Given pigs number of pigs, the total number of distinct outcomes they can represent is
  (
  rounds
- 1
  )
  pigs
  (rounds+1)
  pigs
  .
  To find the poisonous bucket, this number of combinations must cover at least buckets, so:
  (
  rounds
- 1
  )
  pigs
  ≥
  buckets
  (rounds+1)
  pigs
  ≥buckets
  Finding Minimum Number of Pigs:

Using the inequality above, the task becomes finding the smallest number of pigs required so that
(
rounds

- 1
  )
  pigs
  ≥
  buckets
  (rounds+1)
  pigs
  ≥buckets.
  This can be solved by incrementing pigs until the inequality is satisfied.
  Example Walkthrough
  Let’s go through an example where:

buckets = 4
minutesToDie = 15
minutesToTest = 30
Calculate rounds:

# rounds

minutesToTest
minutesToDie
=
30
15
=
2
rounds=
minutesToDie
minutesToTest
​
=
15
30
​
=2
Each pig can represent
rounds

- # 1
  3
  rounds+1=3 states.

We need to find the smallest number of pigs such that:

3
pigs
≥
4
3
pigs
≥4
For pigs = 1,
3
1
=
3
3
1
=3, which is less than 4.
For pigs = 2,
3
2
=
9
3
2
=9, which is greater than 4.
So, we need 2 pigs for this example.
