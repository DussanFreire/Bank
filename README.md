# S.O.L.I.D.

## Single Responsibility Principle.-

In general, this principle was applied in almost the entire project, specifically creating a new class: BankOperator, to reduce the load on the Bank class.

## Open-Close Principle.-

The IWithdrawMoney interface and the abstract classes No commission and commission were created to be able to keep open the extension of being able to add different types of accounts, but closed to the modification of the account types that already exist.

## Liskov Substitution Principle.-

In the same way, the No commission and commission classes were created in order not to alter the current types of accounts with future system updates such as creating new ones or updating them.

## Interface Segregation Principle.-

The interface: IWithdrawMoney was created in order to have to create this method in classes that did not use it as was the case with HousingAccount, which previously had to be implemented since it inherited that method from the account class, but now only the accounts that They need it, implement it and those that don't, shouldn't.

## Dependency Inversion Principle.-

The part of the bank that handled everything was divided into modules and created a high level of dependency, in addition to separating in the same way the types of accounts that previously all depended on a single class.#   B a n k  
 