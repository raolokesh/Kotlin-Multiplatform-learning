package com.jetbrains.kmpapp.screens.base

//
//@Composable
//fun <VM : BaseViewModel> BaseScreen(
//    viewModel: VM,
//    modifier: Modifier = Modifier,
//    content: @Composable (UiState) -> Unit
//) {
//    val uiState by viewModel.uiState.collectAsState()
//    val context = LocalContext.current
//
//    // ----------------- Toast -----------------
//    LaunchedEffect(uiState.toastMessage) {
//        uiState.toastMessage?.let { message ->
//            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
//            viewModel.clearToast()
//        }
//    }
//
//    // ----------------- Error -----------------
//    LaunchedEffect(uiState.errorMessage) {
//        uiState.errorMessage?.let { error ->
//            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
//            viewModel.clearError()
//        }
//    }
//
//    Box(modifier = modifier.fillMaxSize()) {
//        // Your actual screen content
//        content(uiState)
//
//        // ----------------- Loading -----------------
//        if (uiState.isLoading) {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.Black.copy(alpha = 0.3f)),
//                contentAlignment = Alignment.Center
//            ) {
//                CircularProgressIndicator()
//            }
//        }
//    }
//}
