# TravelingSalesMan

Minutes from our breakout room discussion on Monday and from our RocketChat thread:

PLAN:
1. Parse the file inputs and organize them into a 2D array
2. Find the kth permutation (described below)
3. Process this permutation by adding up the distances (helper function)
4. Compare the value of the total distance for that permutation to the minimum distance, which is held in a variable. If the total distance for that permutation is less than the current minimum distance, then the minimum distance is set to the total distance for that permutation.


HOW WE'RE DOING THE PERMUTATIONS:
If you take the kth permutation of 0...n-1 then there are (n-1)! permutations
starting with each element.
if you divide k by (n-1)! you can get the first digit, but within these (n-1)! 
permutations that start with that digit, there are an equal number of permutations
that have some digit as the 2nd digit.
If you keep taking k/(n-1)! for each i and then subbtract tthat out, you can
focus in on one specific permutation.
When you divide k by (n-1)! you're basically choosing a branch.

What it looks like:

                              [0,1,2]  
                              /   |    \
                             0    1     2
                            /\    /\    /\
                           /  \  /  \  /  \
                         01   02 10 12 20  21
                         /    /  \  \   \   \
                       012  021  102 120 201 210

