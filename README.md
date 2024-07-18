<div style="text-align:center">
    <h1>HideFeedBack</h1>

![GitHub License](https://img.shields.io/github/license/NATroutter/HideFeedBack?style=for-the-badge)  
![GitHub Release](https://img.shields.io/github/v/release/NATroutter/HideFeedBack?style=for-the-badge)
![GitHub Downloads (all assets, all releases)](https://img.shields.io/github/downloads/NATroutter/HideFeedBack/total?style=for-the-badge)  
![GitHub last commit](https://img.shields.io/github/last-commit/NATroutter/HideFeedBack?style=for-the-badge&logo=github)
![GitHub issues](https://img.shields.io/github/issues/NATroutter/HideFeedBack?style=for-the-badge&logo=github&foceupdate=1)

HideFeedback is a simple mod that gives you more control over when feedback is sent as commands get executed from different sources.

 </div>
<hr>

### Why not just use "sendCommandFeedback = false"?
Because it doesn't offer enough control over the feedback. For example, if you would have (Server/Console)/CommandBlocks spamming commands, you don't want feedback from those sources, but you want feedback when you execute commands as a player.

### Example use cases
**1. Scheduled commands**   
You could have a scheduler in Pterodactyl to run commands, for example, change scoreboards. But as an op player, you don't want to see the message in chat every time a scoreboard is being changed. You can just set gamerule sendCommandFeedback to false. Then you will not see any feedback when the server executes commands (changes scoreboard).
# Gamerules
### FeedBack From Player
**Effect:** If Disabled when players execute any commands players with op will not be notified in the chat   
**Default:** true
```
/gamerule feedBackFromPlayer true/false
```
### FeedBack From CommandBlock 
**Effect:** If disabled, when command blocks execute any commands, players with op will not be notified in the chat.    
**Default:** true
```
/gamerule feedBackFromCommandBlock true/false
```
### FeedBack From Server
**Effect:** If disabled, when server/console execute any commands, players with op will not be notified in the chat.  
**Default:** true
```
/gamerule feedBackFromServer true/false
```

### Player Feedback
**Effect:** If disabled, when players execute any commands, players with op will not be notified in the chat.  
**Default:** true
```
/gamerule feedBackPlayer true/false
```
### Server Feedback
**Effect:** If disabled, when server/console executes any commands, there is no feedback given.  
**Default:** true
```
/gamerule feedBackServer true/false
```