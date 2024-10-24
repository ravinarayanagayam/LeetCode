The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.

Example 1:

Input: nums = [4,14,2]
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Example 2:

Input: nums = [4,14,4]
Output: 4

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 109
The answer for the given input will fit in a 32-bit integer.

To solve the problem of finding the sum of Hamming distances between all pairs of integers in an array, we need to understand the concept of Hamming distance. The Hamming distance between two integers is defined as the number of positions at which their corresponding bits are different.

Explanation
Hamming Distance Calculation:

The Hamming distance between two numbers can be determined by comparing their binary representations and counting the number of positions where the bits differ.
Efficient Calculation Approach:

Instead of calculating the Hamming distance for every pair individually (which would take
𝑂
(
𝑛
2
)
O(n
2
) time), we can take advantage of bit manipulation for a more efficient solution.
We iterate through each bit position (from 0 to 31, as the problem states that the input will fit in a 32-bit integer). For each bit position, we count how many numbers have a '1' at that position and how many have a '0'.
The total Hamming distance for that bit position is the product of these two counts (count of '1's multiplied by count of '0's), as each '1' can pair with each '0' to create a Hamming distance of 1.
Why This Works:

For each bit position, counting the number of '1's and '0's gives us the number of differing bits for all pairs that can contribute to the Hamming distance at that bit.
