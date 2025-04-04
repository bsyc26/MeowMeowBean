# Final Project Proposal

## Project Description

A community-driven content management system based on weighted mutal rating, providing functionality including user profile, posting and sorting/hiding of content. It aims to become a module that intergrate with Spring Ecosystem and implements automation of building a template forum.

## Basic Functionality

1. Creating/Updating/Deleting of user profile
2. User posting and comment
3. A simple bulletin style front-end web page
 
## Significant Features

1. Maintaining a weighted mutal rating basing score system involving user profile, posting and reviews. Each user will have a score computed based on contribution and involvement of commenting/rating behivours, etc. Users' rating on others will impact the score of other user scaled by their scores
2. User scores will automatically determine whether their posting and comment will be highlighted or hiddened. Likewise, the sorting of content will also based on their scores
3. Providing an option to set up a basic template online forum with default setting in Spring.

## Anticipated Challenges

1. How the score is computed and classcify to avoid error scaling with the increasing user numbers
2. Automation of content management (e.g. sorting) based on scores -- when and how to arrange them
3. Ethics issue: e.g. how to prevent several high-scored person hijack the whole score system and repulse new comers.
