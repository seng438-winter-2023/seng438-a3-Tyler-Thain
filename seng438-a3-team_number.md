**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#:   |    27     |
| -------------- | ------- |
| Jared          | Assen   |
| John           | Delsing |
| Ethan          | Kerr    |
| Tyler          | Thain   |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

In this lab our group looked back on Assignment 2 and used a new coverage tool EclEmma to determine the coverage. We then made new unit tests in order to increase the total coverage and reported the results 

** Please note the EclEmma does not have condition coverage so we used method coverage instead **

For rangeTest, the initial statement coverage was 35.3%, branch coverage was 35.4%, and method coverage was 47.8%. 

// add Data Utilities Test

# 2 Manual data-flow coverage calculations for DataUtillities.calculateColumnTotal and Range.Constraint

Range.Constraint:

Def-Use Sets Per Statement:
|Line|Defs  |Uses             |
|----|------|-----------------|
|1   |value |                 |
|2   |result|value            |
|3   |      |value            |
|4   |      |value, this.upper|
|5   |result|this.upper       |
|7   |      |value, this.lower|
|8   |result|this.lower       |
|11  |      |result           |

Def-Use Pairs Per Variable:
|Variables  |Pairs (def, use)               |
|-----------|-------------------------------|
|value      |(1, 2), (1, 3), (1, 4), (1, 7) |
|result     |(2, 11), (5, 11), (8, 11)      |
|this.upper |(0, 4), (0, 5)                 |
|this.lower |(0, 7), (0, 8)                 |

<span style="text-decoration:underline;">Pairs Covered By Each Test:</span>


<table>
  <tr>
   <td><strong>Test</strong>
   </td>
   <td><strong>Variables</strong>
   </td>
   <td><strong>Pairs</strong>
   </td>
  </tr>
  <tr>
   <td rowspan="4" >belowRangeTest
   </td>
   <td>value
   </td>
   <td>(1, 2), (1, 3), (1, 4), (1, 7)
   </td>
  </tr>
  <tr>
   <td>result
   </td>
   <td>(8, 11)
   </td>
  </tr>
  <tr>
   <td>this.upper
   </td>
   <td>(0, 4)
   </td>
  </tr>
  <tr>
   <td>this.lower
   </td>
   <td>(0, 7), (0, 8)
   </td>
  </tr>
  <tr>
   <td rowspan="4" >onLowerBoundTest
   </td>
   <td>value
   </td>
   <td>(1, 2)
   </td>
  </tr>
  <tr>
   <td>result
   </td>
   <td>(2, 11)
   </td>
  </tr>
  <tr>
   <td>this.upper
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>this.lower
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td rowspan="4" >withinRangeTest
   </td>
   <td>value
   </td>
   <td>(1, 2), (1, 3)
   </td>
  </tr>
  <tr>
   <td>result
   </td>
   <td>(2, 11)
   </td>
  </tr>
  <tr>
   <td>this.upper
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>this.lower
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td rowspan="4" >onUpperBoundTest
   </td>
   <td>value
   </td>
   <td>(1, 2), (1, 3)
   </td>
  </tr>
  <tr>
   <td>result
   </td>
   <td>(2, 11)
   </td>
  </tr>
  <tr>
   <td>this.upper
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>this.lower
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td rowspan="4" >aboveRangeTest
   </td>
   <td>value
   </td>
   <td>(1, 2), (1, 3), (1, 4), (1, 7)
   </td>
  </tr>
  <tr>
   <td>result
   </td>
   <td>(5, 11)
   </td>
  </tr>
  <tr>
   <td>this.upper
   </td>
   <td>(0, 4), (0, 5)
   </td>
  </tr>
  <tr>
   <td>this.lower
   </td>
   <td>(0, 7)
   </td>
  </tr>
</table>


Pair Coverage: 100% (all pair covered)

DataUtilities.calculateColumnTotal:



# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Text…

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

## _Range_: 

<img width="656" alt="Screen Shot 2023-03-02 at 2 50 08 PM" src="https://user-images.githubusercontent.com/91746158/222566698-6a1b6a9a-855c-4daf-b21e-4933c3da6a3b.png">
<img width="664" alt="Screen Shot 2023-03-02 at 2 50 29 PM" src="https://user-images.githubusercontent.com/91746158/222566759-e7f4b0ce-894b-4dae-9429-45ed4a3e7f5b.png">
<img width="622" alt="Screen Shot 2023-03-02 at 2 50 48 PM" src="https://user-images.githubusercontent.com/91746158/222566795-8500a52b-f0df-4f81-8d62-92c4ed45fead.png">
<img width="643" alt="Screen Shot 2023-03-03 at 8 10 41 AM" src="https://user-images.githubusercontent.com/91746158/222756156-8670ea81-5c02-43df-9b42-60f09a0cc68c.png">
<img width="579" alt="Screen Shot 2023-03-02 at 2 51 34 PM" src="https://user-images.githubusercontent.com/91746158/222566900-56e3deb1-0c62-43ec-82b2-ef196399af1f.png">
<img width="624" alt="Screen Shot 2023-03-02 at 2 51 50 PM" src="https://user-images.githubusercontent.com/91746158/222566940-eba7fead-0f8f-4258-aef4-031da91d335a.png">
<img width="584" alt="Screen Shot 2023-03-02 at 2 52 03 PM" src="https://user-images.githubusercontent.com/91746158/222566971-97bbcd6d-137f-498d-89e1-f7bbf9b5a52b.png">

## _Statement:_
<img width="762" alt="Screen Shot 2023-03-02 at 2 55 31 PM" src="https://user-images.githubusercontent.com/91746158/222567658-e5c0b02f-fc74-4c50-a3bc-b125d9e41662.png">

## _Branch:_
<img width="755" alt="Screen Shot 2023-03-02 at 2 55 52 PM" src="https://user-images.githubusercontent.com/91746158/222567728-b679bddc-172f-43a6-99da-2253af48c9c4.png">

## _Method:_
<img width="734" alt="Screen Shot 2023-03-02 at 2 56 17 PM" src="https://user-images.githubusercontent.com/91746158/222567752-1bccc01b-92a5-4ea8-98ae-5350744f29d3.png">

## _DataUtilities_: 

![Coverage](DataUtilities_Images/1.png "Coverage")
![Coverage](DataUtilities_Images/2.png "Coverage")
![Coverage](DataUtilities_Images/3.png "Coverage")
![Coverage](DataUtilities_Images/4.png "Coverage")
![Coverage](DataUtilities_Images/5.png "Coverage")
![Coverage](DataUtilities_Images/6.png "Coverage")
![Coverage](DataUtilities_Images/7.png "Coverage")
![Coverage](DataUtilities_Images/8.png "Coverage")
![Coverage](DataUtilities_Images/9.png "Coverage")
![Coverage](DataUtilities_Images/10.png "Coverage")

## _Statement:_
![Line Coverage](DataUtilities_Images/LineCoverage.png "Statement Coverage")

## _Branch:_
![Branch Coverage](DataUtilities_Images/BranchCoverage.png "Branch Coverage")

## _Method:_ 
![Method Coverage](DataUtilities_Images/MethodCoverage.png "Method Coverage")

# 6 Pros and Cons of coverage tools used and Metrics you report

There are many pros of using EclEmma that were highlighted while we completed this lab. One was that it made it very easy to see the actual coverage that our test cases provided and where we needed to make new ones. Also, it worked well with mockery so we could continue to use mocking in our testing. By seeing the coverage we were easily able to determine how to improve tests and make effective test cases. 

A con that could be considered is that EclEmma does not have every coverage tool. This was seen as out group had to use method coverge instead of condition coverage. 

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

<h3>Requirements-Testing:</h3>

<h3>Coverage-Testing:</h3>

# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

Text…
