package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.data.TodoDao
import com.example.todoapp.data.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideTodoDao(todoDatabase: TodoDatabase):TodoDao = todoDatabase.Tododao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) :TodoDatabase =
        Room.databaseBuilder(
            context,TodoDatabase::class.java,
            "todoDb"
        ).fallbackToDestructiveMigration().build()


}