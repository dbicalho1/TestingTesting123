package com.example.testingtesting123

import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        val item = Item("item1")

        collection.addItem(item)

        assertEquals(1, collection.size())
        assertSame(item, collection.get(0))
    }

    @Test
    fun addUniqueItem() {
        val firstItem = Item("item1")
        val secondItem = Item("item2")

        collection.addItem(firstItem)
        collection.addItem(firstItem)
        collection.addItem(Item("item1"))
        collection.addItem(Item("ITEM1"))
        collection.addItem(secondItem)

        assertEquals(2, collection.size())
        assertSame(firstItem, collection.get(0))
        assertSame(secondItem, collection.get(1))
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size()

        assertEquals(2, originalSize)
        assertEquals("Items not cleared", 0, newSize)
    }
}
