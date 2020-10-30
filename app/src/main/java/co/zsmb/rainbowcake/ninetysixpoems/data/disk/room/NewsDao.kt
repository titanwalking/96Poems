package co.zsmb.rainbowcake.ninetysixpoems.data.disk.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import co.zsmb.rainbowcake.ninetysixpoems.data.disk.room.entities.RoomNewsItem
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM newsitems")
    fun getAllNewsItems(): Flow<List<RoomNewsItem>>

    @Query("SELECT * FROM newsitems WHERE id = :id")
    suspend fun getNewsItemById(id: String): RoomNewsItem?

    @Query("SELECT COUNT(*) FROM newsitems WHERE id = :id")
    suspend fun getCountById(id: String): Int

    @Insert(onConflict = REPLACE)
    suspend fun addNewsItem(toRoomNewsItem: RoomNewsItem)

    @Query("DELETE FROM newsitems WHERE id = :id")
    suspend fun removeNewsItem(id: String)

}
