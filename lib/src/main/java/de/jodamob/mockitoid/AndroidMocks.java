package de.jodamob.mockitoid;


import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyFloat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anySetOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.webkit.WebView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class AndroidMocks {
    public static Context mockContext() {
        return mock(Context.class);
    }

    public static MenuItem mockMenuItem() {
        return mock(MenuItem.class);
    }

    public static MenuItem mockMenuItem(int itemId) {
       MenuItem item = mockMenuItem();
       when(item.getItemId()).thenReturn(itemId);
       return item;
    }

    public static LayoutInflater mockLayoutInflater() {
        LayoutInflater mock = mock(LayoutInflater.class);
        when(mock.inflate(anyInt(), any(ViewGroup.class))).thenReturn(mockView());
        when(mock.inflate(anyInt(), any(ViewGroup.class), anyBoolean())).thenReturn(mockView());
        return mock;
    }

    public static Intent mockIntent() {
        return mock(Intent.class);
    }

    public static Bundle mockBundle() {
        return mock(Bundle.class);
    }

    public static View mockView(ViewPropertyAnimator animator) {
        View view = mockView();
        when(view.animate()).thenReturn(animator);
        return view;
    }

    public static View mockView() {
        return mock(View.class);
    }

    public static View mockView(Resources resources) {
        View mock = mock(View.class);
        when(mock.getResources()).thenReturn(resources);
        return mock;
    }

    @SuppressLint("NewApi")
    public static ViewPropertyAnimator mockViewPropertyAnimator() {
        ViewPropertyAnimator animator = mock(ViewPropertyAnimator.class);
        when(animator.alpha(anyFloat())).thenReturn(animator);
        when(animator.alphaBy(anyFloat())).thenReturn(animator);
        when(animator.rotation(anyFloat())).thenReturn(animator);
        when(animator.rotationBy(anyFloat())).thenReturn(animator);
        when(animator.rotationX(anyFloat())).thenReturn(animator);
        when(animator.rotationXBy(anyFloat())).thenReturn(animator);
        when(animator.rotationY(anyFloat())).thenReturn(animator);
        when(animator.rotationYBy(anyFloat())).thenReturn(animator);
        when(animator.translationX(anyFloat())).thenReturn(animator);
        when(animator.translationXBy(anyFloat())).thenReturn(animator);
        when(animator.translationY(anyFloat())).thenReturn(animator);
        when(animator.translationYBy(anyFloat())).thenReturn(animator);
        when(animator.translationZ(anyFloat())).thenReturn(animator);
        when(animator.translationZBy(anyFloat())).thenReturn(animator);
        when(animator.setDuration(anyLong())).thenReturn(animator);
        return animator;
    }

    public static TextView mockTextView() {
        return mock(TextView.class);
    }

    public static TextView mockTextView(Resources resources) {
        TextView view = mock(TextView.class);
        when(view.getResources()).thenReturn(resources);
        return view;
    }

    public static Button mockButton() {
        return mock(Button.class);
    }

    public static ImageButton mockImageButton() {
        return mock(ImageButton.class);
    }

    public static Fragment mockFragment() {
        return mock(Fragment.class);
    }

    public static Activity mockActivity(Application application) {
        Activity activity = mockActivity();
        when(activity.getApplication()).thenReturn(application);
        return activity;
    }

    public static Activity mockActivity() {
        return mock(Activity.class);
    }

    public static Application mockApplication() {
        return mock(Application.class);
    }

    public static FragmentManager mockFragmentManager() {
        FragmentTransaction transaction = mock(FragmentTransaction.class);
        return mockFragmentManager(transaction);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressLint({ "CommitTransaction", "NewApi" })
    public static FragmentManager mockFragmentManager(FragmentTransaction transaction) {
        FragmentManager fragmentManager = mock(FragmentManager.class);
        when(fragmentManager.beginTransaction()).thenReturn(transaction);
        when(transaction.replace(anyInt(), any(Fragment.class))).thenReturn(transaction);
        when(transaction.replace(anyInt(), any(Fragment.class), anyString())).thenReturn(transaction);
        when(transaction.remove(any(Fragment.class))).thenReturn(transaction);
        when(transaction.addToBackStack(anyString())).thenReturn(transaction);
        when(transaction.add(anyInt(), any(Fragment.class))).thenReturn(transaction);
        when(transaction.add(anyInt(), any(Fragment.class), anyString())).thenReturn(transaction);
        when(transaction.setCustomAnimations(anyInt(), anyInt())).thenReturn(transaction);
        when(transaction.setCustomAnimations(anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(transaction);
        return fragmentManager;
    }

    public static Editable mockEditable(String s) {
        return spy(new EditableStub(s));
    }

    public static EditText mockEditText(Editable editable) {
        EditText field = mock(EditText.class);
        when(field.getText()).thenReturn(editable);
        return field;
    }

    @Deprecated
    public static EditText mockEditField(Editable editable) {
        return mockEditText(editable);
    }

    public static EditText mockEditText(String s) {
        EditText field = mock(EditText.class);
        return prepare(s, field);
    }

    @Deprecated
    public static EditText mockEditField(String s) {
        return mockEditText(s);
    }

    public static Resources mockResources() {
        Resources resources = mock(Resources.class);
        when(resources.getText(anyInt())).thenReturn("");
        when(resources.getString(anyInt())).thenReturn("");
        return resources;
    }

    public static EditText prepare(String s, EditText field) {
        Editable value = spy(new EditableStub(s));
        when(field.getText()).thenReturn(value);
        return field;
    }

    public static TextView mockTextView(String s) {
        TextView field = mock(TextView.class);
        when(field.getText()).thenReturn(s);
        return field;
    }

    public static AutoCompleteTextView mockAutoCompleteEditField(String s) {
        AutoCompleteTextView field = mock(AutoCompleteTextView.class);
        return (AutoCompleteTextView)prepare(s, field);
    }

    public static SharedPreferences.Editor mockEditor() {
        SharedPreferences.Editor editor = mock(SharedPreferences.Editor.class);
        when(editor.putBoolean(anyString(), anyBoolean())).thenReturn(editor);
        when(editor.putInt(anyString(), anyInt())).thenReturn(editor);
        when(editor.putLong(anyString(), anyLong())).thenReturn(editor);
        when(editor.putString(anyString(), anyString())).thenReturn(editor);
        when(editor.putStringSet(anyString(), anySetOf(String.class))).thenReturn(editor);
        return editor;
    }

    public static AlertDialog.Builder mockDialogBuilder() {
        AlertDialog.Builder builder = mock(AlertDialog.Builder.class);
        when(builder.setTitle(anyInt())).thenReturn(builder);
        when(builder.setTitle(anyString())).thenReturn(builder);
        when(builder.setMessage(anyInt())).thenReturn(builder);
        when(builder.setMessage(anyString())).thenReturn(builder);
        when(builder.setPositiveButton(anyInt(), any(DialogInterface.OnClickListener.class))).thenReturn(builder);
        when(builder.setPositiveButton(anyString(), any(DialogInterface.OnClickListener.class))).thenReturn(builder);
        when(builder.setNegativeButton(anyInt(), any(DialogInterface.OnClickListener.class))).thenReturn(builder);
        when(builder.setNegativeButton(anyString(), any(DialogInterface.OnClickListener.class))).thenReturn(builder);
        return builder;
    }

    public static AlertDialog.Builder mockDialogBuilder(ArgumentCaptor<DialogInterface.OnClickListener> positive, ArgumentCaptor<DialogInterface.OnClickListener> negative) {
        AlertDialog.Builder builder = mock(AlertDialog.Builder.class);
        when(builder.setTitle(anyInt())).thenReturn(builder);
        when(builder.setTitle(anyString())).thenReturn(builder);
        when(builder.setMessage(anyInt())).thenReturn(builder);
        when(builder.setMessage(anyString())).thenReturn(builder);
        when(builder.setPositiveButton(anyInt(), positive.capture())).thenReturn(builder);
        when(builder.setNegativeButton(anyInt(), negative.capture())).thenReturn(builder);
        return builder;
    }

    public static CheckBox mockCheckBox() {
        return mock(CheckBox.class);
    }

    public static WebView mockWebView() {
        return mock(WebView.class);
    }

    public static ProgressBar mockProgressBar() {
        return mock(ProgressBar.class);
    }

    public static LinearLayout mockLinearLayout() {
        return mock(LinearLayout.class);
    }

    public static RelativeLayout mockRelativeLayout() {
        return mock(RelativeLayout.class);
    }

    public static FrameLayout mockFrameLayout() {
        return mock(FrameLayout.class);
    }

    public static RecyclerView mockRecyclerView() {
        final RecyclerView recyclerView = mock(RecyclerView.class);

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                when(recyclerView.getAdapter()).thenReturn((RecyclerView.Adapter) invocation.getArguments()[0]);
                return null;
            }
        }).when(recyclerView).setAdapter(any(RecyclerView.Adapter.class));

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                when(recyclerView.getLayoutManager()).thenReturn((RecyclerView.LayoutManager) invocation.getArguments()[0]);
                return null;
            }
        }).when(recyclerView).setLayoutManager(any(RecyclerView.LayoutManager.class));

        return recyclerView;
    }

    public static CardView mockCardView() {
        return mock(CardView.class);
    }
}
