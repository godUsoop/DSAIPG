Problem Description: 
The drunk man takes m steps in a 2D matrix from the starting point (0, 0). He can randomly choose from four directions: North, South, East, or West. Find the relationship between the number of steps m and the distance d.


Observation: 
As the drunk man takes more steps, we can noticed that the distance becomes much farther from the starting point. So we can assume that the number of steps is proportional to the distance.
![Alt text](https://i.imgur.com/6eesvCh.png)


Conclusion: 
To validate the assumption, we can visualize a scatter plot. As you can see, the distribution of the scatter plot aligns with the trend of y = √x
, where x is the number of steps and y is the distance. Therefore, the relationship between the number of steps m and distance d is: d ∝ √m
<img src="https://i.imgur.com/BPj0mNg.png" alt="Alt text" width="500" height="500">