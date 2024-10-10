# Unit Testing with JUnit and JaCoCo - Bank app

## Creation and Execution Process

### Test Setup with JUnit

1.	A test folder was created to store all test files.
2.	Inside the test folder, right-click and select New > JUnit Test Case.
3.	Enter the name of the test in the “Name” field.
4.	Click Finish, and the test will appear in the chosen folder.

### Running Tests and Configuring Coverage with JaCoCo

1.	To run the tests and see the code coverage, click on the second “Play” button and configure the project’s coverage.
2.	Select the option “Run all tests in the selected project, package, or source folder” to view complete coverage.
3.	The console will display the number of tests executed, passed, failed, and skipped.

## Results

The project achieved a total coverage of 81.8%, with the remaining 18.2% primarily consisting of alternative search methods not yet used in the application, along with several files containing constant variables used throughout the program.

However, efforts were made to maximize coverage in the most critical modules, which include Account, Bank, and BankManager. This allowed the team to optimize the sprint by focusing on verifying the correct functionality of these core modules. Based on this approach, the results are considered satisfactory.

## Code Structure: S.O.L.I.D. Principles

### Single Responsibility Principle

This principle was applied throughout most of the project. Specifically, a new class BankOperator was created to reduce the responsibilities of the Bank class.

### Open-Closed Principle

The interface IWithdrawMoney and the abstract classes NoCommission and Commission were introduced to enable extending different account types without modifying the existing ones.


### Liskov Substitution Principle

The NoCommission and Commission classes ensure that the current account types are not affected by future updates or the addition of new accounts.

### Interface Segregation Principle

The interface IWithdrawMoney was created to avoid forcing classes to implement methods they do not use. For instance, the HousingAccount class previously had to implement the method from the Account class, but now only accounts that require it implement it, while others do not.

### Dependency Inversion Principle

The responsibilities handled by the Bank class were divided into smaller modules, creating a higher-level dependency. Additionally, the account types were separated, whereas before they all depended on a single class.

## References
* Code Report: https://docs.google.com/document/d/1buC5zROhoB11TnzNdj1LYlQdBLAEp-mD4scKg1dxlGE/edit?usp=sharing
