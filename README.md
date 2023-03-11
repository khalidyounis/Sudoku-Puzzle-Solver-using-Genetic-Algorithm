
<img src="https://www.liverpool.ac.uk/logo-size-test/full-colour.svg" alt="mypy logo" width="300px"/>

# Sudoku Puzzle Solver using Genetic Algorithm

## Background

Software application that solves a puzzle game similar to **Sudoku** using genetic algorithms. The objective is to fill a grid of size 4x4 with four different letters so that each column, each row, and each of the four sub-grids of size 2x2 contain each of the letters only once. It was developed for the CSCK502 Reasoning and Intelligent Systems October 2022 End-Module group assignment at the University of Liverpool.

## Table of Contents

- [Prerequisites](#prerequisites)

- [Usage](#usage)

- [Contribution](#contribution)

- [License](#license)
  

## Prerequisites

The expert system was developed in Java programming using Apache NetBeans IDE therefore it requires Java Runtime Environment to run the application.

- [Java Runtime Environment]
https://www.java.com/download/ie_manual.jsp
  
## Usage

1. You can launch the application using one of these methods

	**a.** Go to the dist folder in the source code directory and double-click the jar file

			SPGA.jar
	**b.** Run the application from the command line, go to the dist folder and type the following command:

			java -jar "SPGA.jar" 	
			
2. To resolve the puzzle, the user is asked to input the word with four unique letters. The application verifies the word against the number of characters, which should be four and unique. The user can also Skip entering the four letters manually in the grid boxes:
![enter image description here](https://i.imgur.com/pHMRXJ6.png)
3. The user can also enter the four letters manually in the grid boxes:
![enter image description here](https://i.imgur.com/6lsf0wg.png)
5. After the user clicks the **Solve** button, the program initiates and tries to solve the puzzle. The process log will be displayed with all the populations generated until the Sudoku puzzle solver reaches its goal:
![enter image description here](https://i.imgur.com/wffkRc4.png)

After resolving the puzzle, the program shows the process log with the number of populations generated to achieve the required goal and elapsed time

## Contributing

Any contribution to improve the application is possible.

## License

[MIT](LICENSE) © Group A