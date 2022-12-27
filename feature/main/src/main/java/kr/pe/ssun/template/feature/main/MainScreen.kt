package kr.pe.ssun.template.feature.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import kr.pe.ssun.template.feature.main.MainUiState.*

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MainRoute(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val mainState by viewModel.mainUiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getProduct()
    }

    MainScreen(
        mainState = mainState,
        modifier = modifier
    )
}

@Composable
fun MainScreen(
    mainState: MainUiState,
    modifier: Modifier = Modifier,
) {
    val state = rememberLazyListState()
    Box(modifier = modifier.fillMaxSize()) {
        when (mainState) {
            Loading -> { CircularProgressIndicator(modifier = Modifier.align(Alignment.Center)) }
            Error -> {}
            is Success -> {
                LazyColumn(
                    state = state,
                ) {
                    // TODO : :core:ui로 분리
                    items(
                        count = mainState.photos.size,
                        itemContent = { index ->
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)) {
                                AsyncImage(
                                    modifier = Modifier.size(80.dp),
                                    model = mainState.photos[index].thumbnailUrl,
                                    contentDescription = null
                                )
                                Text(mainState.photos[index].title)
                            }
                        }
                    )
                }
            }
        }
    }
}