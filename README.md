# Project Name

## Team Information

### Team Members
- Enoch Wang
- Caleb Chang
- Ryan Chan
- Levi He
- Samuele Bonardi
---

## Project Description

### Domain

[Project description]
 
---

## User Stories

### User Story 1
As a chess player, I want to import my recent games by entering my Chess.com account, showing the basic information of the matches, so that I can track and analyze them.
### User Story 2

### User Story 3

As a chess player, I want to ask an engine to evaluate the position I am looking at and suggest the best move, so that I can understand what I should have played.

### User Story 4
As a chess player, I want the app to review an entire game and classify my moves, so that I can see how many good and bad moves I did.

### User Story 5
 
As a chess player, I want to see statistics about my games, such as time control, most used openings and win rates per color, so I can find patterns in my strengths and weaknesses and find areas of improvement.

## Use Cases

### Use Case 1: Import games

**Primary actor:** Player

**Preconditions:**
- The player enters a valid timeframe.
- The player enters a valid Chess.com username.

**Trigger:** The player enters a Chess.com username and clicks "Import".

**Success outcome:** The player's games from the selected timeframe are saved in local storage and shown in the game list with their basic information.

**Main success scenario:**
1. The player enters a Chess.com username, selects how many recent months to import, and clicks "Import".
2. The system requests the player's monthly game archives from the Chess.com API.
3. The Chess.com API returns the games for each requested month.
4. The system stores each game's move notation and metadata (date, players, colour, result, time control, ratings) into Game entities.
5. The system saves the new games to local storage.
6. The system displays the game list, showing each game's date, opponent, colour, result, and time control.


### Use Case 2

### Use Case 3

### Use Case 4

### Use Case 5
 
---

## Minimal Viable Product (MVP)

| Team Member | MVP Use Case |
|-------------|--------------|
| Enoch Wang  | Use Case     |
| Caleb Chang | Use Case     |
| Ryan Chan   | Use Case     |
| Levi He     | Use Case     |
| Samuele Bonardi | Use Case     |
 
---

## Entities

### Entity 1

### Entity 2

(Add additional entities as needed.)
 
---

## API Usage

**API Name:**

**Documentation:** [Link](https://example.com)

**How it is used in the program:**
 
---

## Design Diagrams

### UML Class Diagram

<!-- Add image: ![UML Class Diagram](docs/uml-class-diagram.png) -->

### Sequence Diagrams

<!-- Add image: ![Sequence Diagram](docs/sequence-diagram.png) -->
 
---

## How to Run

```bash
# Instructions for running the program
```
 
---

## Notes

[Any additional project information.]