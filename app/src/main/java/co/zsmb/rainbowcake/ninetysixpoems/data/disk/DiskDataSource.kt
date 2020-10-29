package co.zsmb.rainbowcake.ninetysixpoems.data.disk

import co.zsmb.rainbowcake.ninetysixpoems.data.disk.entities.RoomNewsItem
import co.zsmb.rainbowcake.ninetysixpoems.domain.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiskDataSource @Inject constructor(
    private val newsDao: NewsDao
) {

    fun getSavedNews(): Flow<List<News>> {
        return newsDao.getAllNewsItems().map { news -> news.map(RoomNewsItem::toNews) }
    }

    suspend fun getSavedNewsItemById(id: String): News? {
        return newsDao.getNewsItemById(id)?.let(RoomNewsItem::toNews)
    }

    suspend fun saveNewsItem(news: News) {
        return newsDao.addNewsItem(news.toRoomNewsItem())
    }

    suspend fun removeSavedNewsItem(id: String) {
        newsDao.removeNewsItem(id)
    }

    suspend fun hasNewsItem(id: String): Boolean {
        return newsDao.getCountById(id) != 0
    }

}
