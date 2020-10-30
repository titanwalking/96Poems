package co.zsmb.rainbowcake.ninetysixpoems.data.disk.room

import co.zsmb.rainbowcake.ninetysixpoems.data.disk.room.entities.RoomNewsItem
import co.zsmb.rainbowcake.ninetysixpoems.domain.News

fun News.toRoomNewsItem(): RoomNewsItem {
    return RoomNewsItem(
        id = id,
        headline = headline,
        trailText = trail,
        thumbnailUrl = thumbnailUrl,
        content = content
    )
}

fun RoomNewsItem.toNews(): News {
    return News(
        id = id,
        headline = headline,
        trail = trailText,
        thumbnailUrl = thumbnailUrl,
        content = content
    )
}
