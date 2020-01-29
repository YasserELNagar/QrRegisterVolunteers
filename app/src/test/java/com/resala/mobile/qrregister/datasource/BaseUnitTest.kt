/*
 * Created by  Mobile Dev Team  on 1/11/20 9:35 AM
 * Copyright (c) Resala Charity Organization. All rights reserved.
 */

package com.resala.mobile.qrregister.datasource

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.resala.mobile.qrregister.datasource.di.testApp
import com.resala.mobile.qrregister.shared.util.SharedPref
import org.junit.Before
import org.junit.Rule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.test.AutoCloseKoinTest
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

open class BaseUnitTest : AutoCloseKoinTest() {

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        startKoin {
            androidContext(Mockito.mock(Context::class.java))
            printLogger(Level.DEBUG)
            modules(testApp)
            declareMock<SharedPref> {

            }
        }
    }


    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val rule2 = RxSchedulersOverrideRule()

}