## Context

A curated collection of Data Structures & Algorithms patterns implemented in Java and documented with step-by-step explanations.  

This repository mainly serves as a personal learning & revising resource.

> You can use this repository to understand the patterns to solve DSA questions.

Key points
- 
- [Contribution Guide](#git-guidelines) (Contribution guidelines)
- [Pattern Template](#pattern-template) (Template to get started)
- [Goals](#goals) (Core focus)
- [File Structure Guidance](#repository-structure) (where is what)

---

## Get Started
1. Clone repository:

   `git clone https://github.com/<your-username>/dsa-patterns-handbook.git`


2. Navigate to local repository

   `cd dsa-patterns-handbook`


3. Create a new branch

   `git checkout -b <branch-name-with-set-conventions>`


4. Make changes & commit

   ````markdown
    git add .

    git commit -m "<commit-message-with-set-conventions>"
   ````


5. Push your changes & additions to this repository

   ````markdown
    # Add a remote repo (if haven't already)
    git remote add origin https://github.com/<your-username>/dsa-patterns-handbook.git

    # Push the changes made
    git push -u origin main
   ````           

6. Make a Pull Request with your own style, so I can copy your style if I like it😏


7. Wow, Congratulations🥂🎉

    You just made a contribution to save the **Humanity**!
---

## Git Guidelines

This repository follows simplified, professional Git conventions optimized for an educational codebase where clarity, topic organization, and clean history matter more than complex release flows.

### Branching Model

We use a lightweight trunk-based model with short-lived feature branches.

* `main` → Always stable and contains verified, reviewed patterns.
* `pattern/` → For adding new **patterns**, **questions**, explanations.
* `docs/` → For updates to documentation (README, pattern markdowns).
* `refactor/` → For restructuring code or renaming folders or optimised logic.
* `chore/` → For minor housekeeping tasks like `.gitignore` or config updates.
* `experiment/` → For testing alternate solutions or approaches temporarily.

> ⚠️ Branches should be short-lived and merged quickly to keep history linear and clean.


### Branch Naming Rules

* Use lowercase, hyphen-separated words.
* Prefix branch with its purpose (`pattern/`, `docs/`, etc.).
* Optionally include topic name or DSA concept.

Examples:
- `pattern/arrays-sliding-window`
- `pattern/dp-knapsack`
- `docs/update-readme`
- `refactor/rename-dp-folder`
- `chore/setup-gitignore`


### Commit Message Conventions

- We follow the Conventional Commits format, simplified for algorithmic documentation.

   ````markdown
    <type>(<scope>): <short description>
    <optional-details/explanation>
   ````

---

## Pattern Template

Use this template when adding new patterns or problems.

````markdown

[Pattern]: pattern name

- When to recognize: signals/shape of input

- Brute force baseline: O(…) & why it’s too slow

- Core idea: one key invariant/insight

- Algorithm (steps): step by step explanation
  
- Complexity: Time O(?), Space O(?) + add line by line explanation for both.
  
- Edge cases: list of edge cases
  
- Variants: when this pattern breaks / common twists
  
- Code (Java): short, clean implementation  

- Thoughts: Your relevant thoughts around this specific pattern/question

````
---

## Goals
To be smooth in pattern recognition and algorithmic reasoning rather than memorization.

Every problem included here focuses on:
- Identifying the underlying pattern.
- Explaining the reasoning path.
- Writing clean, optimized code.
- Time & Space complexities.

---

## Repository Structure
> This will keep changing as per my learnings (Every day)

````markdown

dsa-patterns-handbook/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── rushikesh/
│                   └── dsa/
│                       ├── arrays/
│                       ├── binarysearch/
│                       ├── dp/
│                       ├── graphs/
│                       ├── linkedlist/
│                       ├── queues/
│                       ├── stacks/
│                       ├── strings/
│                       └── trees/


````
---