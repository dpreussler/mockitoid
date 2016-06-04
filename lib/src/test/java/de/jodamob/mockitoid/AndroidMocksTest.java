package de.jodamob.mockitoid;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.anyFloat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class AndroidMocksTest {

    @Test
    public void mockAutoCompleteEditField() {
        EditText editText = AndroidMocks.mockAutoCompleteEditField("test");
        assertThat(editText.getText().toString()).isEqualTo("test");
    }

    @Test
    public void mockEditText() {
        EditText editText = AndroidMocks.mockEditText("test");
        assertThat(editText.getText().toString()).isEqualTo("test");
    }

    @Test
    public void mockTextView() {
        TextView textView = AndroidMocks.mockTextView();
        assertThat(textView).isNotNull();
    }

    @Test
    public void mockTextViewWithString() {
        TextView textView = AndroidMocks.mockTextView("test");
        assertThat(textView).isNotNull();
        assertThat(textView.getText().toString()).isEqualTo("test");
    }

    @Test
    public void mockTextViewWithResource() {
        Resources resources = mock(Resources.class);
        TextView textView = AndroidMocks.mockTextView(resources);
        assertThat(textView).isNotNull();
        assertThat(textView.getResources()).isEqualTo(resources);
    }

    @Test
    public void mockButton() {
        Button button = AndroidMocks.mockButton();
        assertThat(button).isNotNull();
    }

    @Test
    public void mockCheckBox() {
        CheckBox button = AndroidMocks.mockCheckBox();
        assertThat(button).isNotNull();
    }

    @Test
    public void mockImageButton() {
        ImageButton button = AndroidMocks.mockImageButton();
        assertThat(button).isNotNull();
    }

    @Test
    public void mockActivity() {
        Activity activity = AndroidMocks.mockActivity();
        assertThat(activity).isNotNull();
    }

    @Test
    public void mockActivityWithApplication() {
        Application application = mock(Application.class);
        Activity activity = AndroidMocks.mockActivity(application);
        assertThat(activity).isNotNull();
        assertThat(activity.getApplication()).isEqualTo(application);
    }

    @Test
    public void mockApplication() {
        Application application = AndroidMocks.mockApplication();
        assertThat(application).isNotNull();
    }

    @Test
    public void mockBundle() {
        Bundle bundle = AndroidMocks.mockBundle();
        assertThat(bundle).isNotNull();
    }

    @Test
    public void mockCardView() {
        CardView cardView = AndroidMocks.mockCardView();
        assertThat(cardView).isNotNull();
    }

    @Test
    public void mockView() {
        View view = AndroidMocks.mockView();
        assertThat(view).isNotNull();
    }

    @Test
    public void mockViewWithResources() {
        Resources resources = mock(Resources.class);
        View view = AndroidMocks.mockView(resources);
        assertThat(view).isNotNull();
        assertThat(view.getResources()).isEqualTo(resources);
    }

    @Test
    public void mockViewWithAnimator() {
        ViewPropertyAnimator viewPropertyAnimator = mock(ViewPropertyAnimator.class);
        View view = AndroidMocks.mockView(viewPropertyAnimator);
        assertThat(view).isNotNull();
        assertThat(view.animate()).isEqualTo(viewPropertyAnimator);
    }

    @Test
    public void mockRecyclerView() {
        RecyclerView view = AndroidMocks.mockRecyclerView();
        assertThat(view).isNotNull();
        assertThat(view.getAdapter()).isNull();
        assertThat(view.getLayoutManager()).isNull();
        view.setLayoutManager(mock(RecyclerView.LayoutManager.class));
        assertThat(view.getLayoutManager()).isNotNull();
        view.setAdapter(mock(RecyclerView.Adapter.class));
        assertThat(view.getAdapter()).isNotNull();
    }

    @Test
    public void mockWebView() {
        View view = AndroidMocks.mockWebView();
        assertThat(view).isNotNull();
    }

    @Test
    public void mockLinearLayout() {
        LinearLayout view = AndroidMocks.mockLinearLayout();
        assertThat(view).isNotNull();
    }

    @Test
    public void mockRelativeLayout() {
        RelativeLayout view = AndroidMocks.mockRelativeLayout();
        assertThat(view).isNotNull();
    }

    @Test
    public void mockFrameLayout() {
        FrameLayout view = AndroidMocks.mockFrameLayout();
        assertThat(view).isNotNull();
    }

    @Test
    public void mockContext() {
        Context context= AndroidMocks.mockContext();
        assertThat(context).isNotNull();
    }

    @Test
    public void mockDialogBuilder() {
        AlertDialog.Builder builder = AndroidMocks.mockDialogBuilder();
        assertThat(builder).isNotNull();
    }

    @Test
    public void mockDialogBuilderWithListeners() {
        ArgumentCaptor<DialogInterface.OnClickListener> positive = ArgumentCaptor.forClass(DialogInterface.OnClickListener.class);
        ArgumentCaptor<DialogInterface.OnClickListener> negative = ArgumentCaptor.forClass(DialogInterface.OnClickListener.class);
        AlertDialog.Builder builder = AndroidMocks.mockDialogBuilder(positive, negative);
        assertThat(builder).isNotNull();
    }

    @Test
    public void mockFragment() {
        Fragment fragment = AndroidMocks.mockFragment();
        assertThat(fragment).isNotNull();
    }

    @Test
    public void mockFragmentManager() {
        FragmentManager fragmentManager = AndroidMocks.mockFragmentManager();
        assertThat(fragmentManager).isNotNull();
    }

    @Test
    public void mockFragmentManagerWithTransaction() {
        FragmentTransaction transaction = mock(FragmentTransaction.class);
        FragmentManager fragmentManager = AndroidMocks.mockFragmentManager(transaction);
        assertThat(fragmentManager).isNotNull();
        assertThat(fragmentManager.beginTransaction()).isEqualTo(transaction);
    }

    @Test
    public void mockIntent() {
        Intent intent = AndroidMocks.mockIntent();
        assertThat(intent).isNotNull();
    }

    @Test
    public void mockLayoutInflater() {
        LayoutInflater inflater = AndroidMocks.mockLayoutInflater();
        assertThat(inflater).isNotNull();
    }

    @Test
    public void mockProgressBar() {
        ProgressBar progressBar = AndroidMocks.mockProgressBar();
        assertThat(progressBar).isNotNull();
    }

    @Test
    public void mockResources() {
        Resources resources = AndroidMocks.mockResources();
        assertThat(resources).isNotNull();
        assertThat(resources.getString(anyInt())).isNotNull();
        assertThat(resources.getText(anyInt())).isNotNull();
    }

    @Test
    public void mockViewPropertyAnimator() {
        ViewPropertyAnimator animator = AndroidMocks.mockViewPropertyAnimator();
        assertThat(animator).isNotNull();
        assertThat(animator.alpha(anyFloat())).isEqualTo(animator);
        assertThat(animator.rotation(anyFloat())).isEqualTo(animator);
        // smoke test only

    }
}