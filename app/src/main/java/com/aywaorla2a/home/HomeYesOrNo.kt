package com.aywaorla2a.home

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.request.ImageRequest
import com.aywaorla2a.R
import com.aywaorla2a.response.YesOrNoResponse
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp
import kotlinx.coroutines.delay


@Composable
fun YesOrNo(yesOrNoViewModel: YesOrNoViewModel) {

    val context = LocalContext.current
    val yesOrno by yesOrNoViewModel.yesOrNoData.observeAsState(null)
    val error = yesOrNoViewModel.errorMessage.observeAsState().value
    var refreshing by remember { mutableStateOf(false) }

    SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing = refreshing), onRefresh = {
        refreshing = true
    }) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.sdp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {

                if (yesOrno == null) {
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(align = Alignment.Center)

                        )
                    }
                    Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                } else {
                    item {
                        FetchYesOrNo(yesOrno!!, context)
                        LaunchedEffect(refreshing) {
                            if (refreshing) {
                                delay(2000)
                                yesOrNoViewModel.fetchYesOrNo()
                                refreshing = false
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun FetchYesOrNo(yesOrno: YesOrNoResponse, context: Context) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = yesOrno.answer,
            fontSize = 23.ssp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(5.sdp))

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.sdp), painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(context).data(yesOrno.image).crossfade(3000).build(),
                placeholder = painterResource(id = R.drawable.gif_image),
                imageLoader = ImageLoader.Builder(context).components {
                    add(GifDecoder.Factory())
                }.build()
            ), contentDescription = "(Yes Or No) Image Description"
        )

        Spacer(modifier = Modifier.padding(5.sdp))
    }
}