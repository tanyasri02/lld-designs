Requirement

1. We should be able to create groups
2. We should be able to add users to the group
3. We should be able to create the expense in group or 1:1, or 1:2
4. We should be able to view their BALANCE_SHEET for each group
    1. (total_amount_paid, total_expense, balance_with_others)
5. User can simplify the debt

Extensible

While creating an expensive, we can choose how to split - equal, percentage(means she owes 5% of this) 


Entities

- User
- Group
- Expense
- ExpenseSplit
- Settlement

Services

1. ExpenseService
2. SplitManager
3. DebtSimplifier
4. SettlementService

<img width="1156" height="748" alt="image" src="https://github.com/user-attachments/assets/a8ef8048-dc86-4313-924f-8eee4ae5730d" />
