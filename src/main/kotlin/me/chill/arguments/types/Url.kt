package me.chill.arguments.types

import me.chill.arguments.Argument
import me.chill.arguments.ArgumentParseMap
import net.dv8tion.jda.core.entities.Guild

class Url : Argument {
  override fun check(guild: Guild, arg: String): ArgumentParseMap {
    val urlRegex = Regex("https?://(www\\.)?[-a-zA-Z0-9@:%._+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_+.~#?&//=]*)")

    if (!urlRegex.matches(arg)) {
      return ArgumentParseMap(false, "Input: **$arg** is not a valid URL")
    }

    return ArgumentParseMap(true, parsedValue = arg)
  }
}