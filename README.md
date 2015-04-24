# AviatorAPI
API For ServerSide Forge Mods

AviatorAPI is an API adding several features to MinecraftForge in order to improve it for serverside mod implementation. In my quest to develop a wide array of serverside mods for Forge (So that popular Forge mods can receive the same benefits of a Cauldron server, but in Minecraft 1.8) I have found that several features are common in each of my mods, as such I have decided it would be best to group these features into a single API to be utilized by my mods, and anyone else's mods who wish to develop serverside mods.

Planned Features

Permissions API
The permissions API will provide mods the ability to use simpler methods for creating permission based features without having to create a separate class for handling permissions. Permissions data will be stored in YML format to allow for manipulation from within the game and externally through editing the configuration. The API will recognize and read the permissions currently coded by other mods as well.

Database API
The database API will provide a simpler environment for creating databases and modifying them, relatively free from the use of SQL syntax. Developers utilizing this API can freely create database files, create tables, and easily store data utilizing static methods and simple easy-to-understand classes.

Event API
The majority of events available from MinecraftForge are vague and not specific, the Event API will expand upon this to include more specific events. For example, to find if a player breaks a block with an axe, you currently must listen to BlockBreakEvent, get the player from the event, get the item in the player's hand, check if it's an axe, and continue code from that point. The Event API aims to condense this into a simple ToolBreakEvent you can .getTool() from, or possibly an even more specific AxeBreakEvent.

Player Information API
For every player that joins a server, several bits of information will be saved including their UUID, username, and IP addresses. UUIDs are not available when the player is offline, but having them saved will allow code to pull up their UUID with just their username. The database will automatically update when their names are changed. This will also provide a threaded method for retrieving UUIDs for players that have never joined before, if truly necessary.

Chatbox API
This will include simple methods for sending information in chat to players or the console. Currently, you must create a ChatComponentText object and pass that with player.addChatMessage(); a process that hogs a lot of space in your code. Send this type of information easily with a single method, and simultaneously color the message however you want without throwing EnumChatFormatting enums all over the place.

Methods/Utilities API
This will simply include a selection of utility classes with static methods for everything from simple teleportation to timers. Developers will be able to use these methods to simplify their code and focus more on the important things.

For now, these are the features I plan to create in the API. As I move forward, I may start to add additional planned features and ideas to this list.
