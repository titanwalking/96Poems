package co.zsmb.rainbowcake.ninetysixpoems.data.disk

import androidx.room.Database
import androidx.room.RoomDatabase
import co.zsmb.rainbowcake.ninetysixpoems.data.disk.entities.RoomNewsItem

@Database(
    entities = [RoomNewsItem::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}
