<div align="center">

# DSA Patterns Handbook
### A Systematic Approach to Data Structures, Algorithms, and Interview Patterns.

[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://github.com/DominiK037/dsa-patterns-handbook/graphs/commit-activity)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](http://makeapullrequest.com)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

</div>

---

## Context & Objective 📖

This repository serves as a centralized knowledge base for Data Structures & Algorithms (DSA). It focuses on **pattern recognition** rather than rote memorization.

The content is structured to assist in:

1. **Systematic Revision:** Quick lookup for specific data structures and their internal workings.
2. **Pattern Application:** Mapping common problem statements to optimized algorithmic patterns (e.g., Sliding Window, Two Pointers).
3. **Interview Readiness:** A filtered list of high-ROI problems derived from industry standards.

> **Note:** This handbook aggregates knowledge from high-quality sources including the *Tech Interview Handbook* and *GitHub Repositories*, refined through personal implementation and testing.

---

## 🗺️ Pattern Roadmap

The core of this repository. Topics are prioritized based on their frequency in technical interviews for backend and systems engineering roles.

| Data Structure | Implementation & Patterns | Interview Frequency |
| :--- | :--- | :--- |
| **Array** | [📄 View Docs](array/Array.md) | 🔥 **High** |
| **String** | [📄 View Docs](string/String.md) | 🔥 **High** |
| **Tree** | [📄 View Docs](tree/Tree.md) | 🔥 **High** |
| **Graph** | [📄 View Docs](graph/Graph.md) | 🔥 **High** |
| **Binary Search**| [📄 View Docs](binarysearch/BinarySearch.md)| 🔥 **High** |
| **Sorting** | [📄 View Docs](sorting/Sorting.md) | 🔥 **High** |
| **Hash Table** | [📄 View Docs](hashtable/HashTable.md) | ⚡ **Mid** |
| **Linked List** | [📄 View Docs](linkedlist/LinkedList.md) | ⚡ **Mid** |
| **Recursion** | [📄 View Docs](recursion/Recursion.md) | ⚡ **Mid** |
| **Stack** | [📄 View Docs](stack/Stack.md) | ⚡ **Mid** |
| **Heap** | [📄 View Docs](heap/Heap.md) | ⚡ **Mid** |
| **Queue** | [📄 View Docs](queue/Queue.md) | ⚡ **Mid** |
| **Trie** | [📄 View Docs](trie/Trie.md) | ⚡ **Mid** |
| **Dynamic Programming** | [📄 View Docs](dynamicprogramming/DynamicProgramming.md) | 🧊 **Low** |

---

## 📚 References & Resources

This repository is built upon the following foundational resources. I highly recommend them for deep-dive learning:

1. **Interview Strategy:** [Tech Interview Handbook](https://github.com/yangshun/tech-interview-handbook) – *The gold standard for interview process understanding.*
2. **Fundamentals:** [Structy](https://structy.net/) – *Excellent visualizations & dry runs for base data structures.*
3. **Pattern Logic:** [Grokking Patterns](https://github.com/Chanda-Abdul/Several-Coding-Patterns-for-Solving-Data-Structures-and-Algorithms-Problems-during-Interviews/) – *Essential for understanding pattern mapping.*
4. **Practice Set:** [NeetCode 250](https://neetcode.io/practice?tab=neetcode250) – *Curated list of problems with optimal solutions.*

---

## 🤝 Contribution Guidelines

Contributions to optimize code, improve documentation, or add new patterns are welcome. Please adhere to the branching model below to ensure repository stability.

### Workflow

1. Fork and Clone the repository.
2. Create a branch specific to your change type (see below).
3. Submit a Pull Request targeting the `main` branch.

### Branching Model

Strict adherence to naming conventions is required:

* `docs/<name>` → Updates to README or documentation files.
* `refactor/<name>` → Code restructuring or renaming without logic changes.
* `chore/<name>` → Housekeeping (configs, .gitignore, etc.).

```bash
# Example
git checkout -b docs/sliding-window-fix
git commit -m "fix: corrected edge case in sliding window maximum"
git push origin docs/sliding-window-fix
```
