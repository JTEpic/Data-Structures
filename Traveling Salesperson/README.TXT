PROJECT TITLE: Traveling Salesperson Problem
PURPOSE OF PROJECT: Implement two greedy heuristics in the attempt to find
an optimal solution to the Traveling Salesperson Problem
DATE: 12/8
AUTHOR: JTEpic & APCode
ALGORITHM DESCRIPTIONS: 
    insertNearest()
    To make sure no errors, if first point is not added, p is added using add
    method. If not, a loop goes through to find the least distance between p 
    and list values, and sets small node to least distance pos. P is added 
    after small ListNode in the end. Size is increased.
    O(N squared) - from adding one point using while loop and
    then the entire ListNode
    
    insertSmallest()
    To make sure no errors, if first, second, or third are not added, p is added
    using add method. Loop goes through list to find least change in distance from 
    the old still connected 2 points and the addition of p to make 3 points. The least
    change node is saved in loc. As well, first node and last are tested for the
    same measures. P is added after the loc ListNode in the end. Size is increased.
    O(N squared) - one point requires while loop like insertNearest(), and
    adding all points require all points
